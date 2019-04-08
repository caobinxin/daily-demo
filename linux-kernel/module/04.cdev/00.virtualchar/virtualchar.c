#include <linux/module.h>
#include <linux/types.h>
#include <linux/fs.h>
#include <linux/errno.h>
#include <linux/mm.h>
#include <linux/sched.h>
#include <linux/init.h>
#include <linux/cdev.h>
#include <asm/io.h>
#include <linux/uaccess.h>

#define MEM_SIZE 0x1000 /*全局内存大小: 4kb*/
#define MEM_CLEAR 0x1 /*清除全局内存*/
#define VIRTUALCHAR_MAJOR 0 /*预设的globalmem的主设备号*/

static int virtualchar_major = VIRTUALCHAR_MAJOR ;

/*virtualchar 设备结构体*/
struct virtualchar_dev
{
    /* data */
    struct cdev cdev;
    unsigned char mem[MEM_SIZE] ;
};

struct virtualchar_dev dev;


static ssize_t virtualchar_read(struct file *filp, char __user *buf, size_t count, loff_t *ppos)
{
    unsigned long p = *ppos ;
    int ret = 0 ;

    /*分析和获取有效的读长度*/
    if( p >= MEM_SIZE)//要读的偏移位置越界
    {
        return count ? -ENXIO: 0 ;
    }

    if(count > MEM_SIZE - p) //要读的字节数太大
    {
        count = MEM_SIZE - p ;
    }

    /*内核空间 -> 用户空间*/
    if(copy_to_user(buf, (void *)(dev.mem + p), count))
    {
        ret = -EFAULT ;
    }else
    {
        /* code */
        *ppos += count ;
        ret = count ;
 
        printk(KERN_INFO"read %ld bytes(s) from %ld\n", count, p) ;
    }

    return ret ;
}

static ssize_t virtualchar_write(struct file *filp, const char __user *buf, size_t count, loff_t *ppos)
{
    unsigned long p = *ppos ;
    int ret = 0 ;

    /*分析和获取有效的写长度*/
    if( p >= MEM_SIZE)//要写的偏移位置越界
    {
        return count ? -ENXIO: 0 ;
    }

    if(count > MEM_SIZE - p)//要写的字节数太大
    {
        count = MEM_SIZE - p ;
    }

    /*用户空间 -> 内核空间*/
    if( copy_from_user(dev.mem + p, buf, count))
    {
        ret = -EFAULT ;
    }else
    {
        /* code */
        *ppos += count ;
        ret = count ;

        printk(KERN_INFO "written %ld bytes(s) from %ld\n", count, p) ;
    }
    
    return ret ;
}

static loff_t virtualchar_llseek(struct file *filp, loff_t offset, int orig)
{
    loff_t ret ;
    switch(orig)
    {
        case 0: /*从文件开头开始偏移*/
            if( offset < 0)
            {
                ret = -EINVAL ;
                break ;
            }

            if( (unsigned int) offset > MEM_SIZE) //偏移越界
            {
                ret = -EINVAL ;
                break ;
            }

            filp->f_pos = (unsigned int )offset ;
            ret = filp->f_pos ;
            break ;
        
        case 1:/*从当前位置开始偏移*/
            if( (filp->f_pos + offset) > MEM_SIZE)//偏移越界
            {
                ret = -EINVAL ;
                break ;
            }
            if( (filp->f_pos + offset) < 0)
            {
                ret = -EINVAL ;
                break ;
            }
            filp->f_pos += offset;
            ret = filp->f_pos ;
            break ;

        default:
            ret = -EINVAL ;
    }

    return ret ;
}

long virtualchar_ioctl(struct file *filp, unsigned int cmd, unsigned long arg)
{
    switch (cmd)
    {
        case MEM_CLEAR/* constant-expression */:
            /* code */
            memset(dev.mem, 0, MEM_SIZE) ;
            printk(KERN_INFO "Virtualchar memory is set to zero.\n") ;
            break;
    
        default:
            return -EINVAL ;
    }

    return 0L ;
}

int virtualchar_open (struct inode * v_inode, struct file *filp)
{
    printk(KERN_INFO"Virtualchar open success.") ;
    return 0 ;
}

int virtualchar_release (struct inode *v_inode, struct file *filp)
{
    printk(KERN_INFO"Virtualchar close success.") ;
    return 0 ;
}

static const struct file_operations virtualchar_fops =
{
    .owner = THIS_MODULE,
    .llseek = virtualchar_llseek,
    .read = virtualchar_read,
    .write = virtualchar_write,
    .compat_ioctl = virtualchar_ioctl,
    .open = virtualchar_open,
    .release = virtualchar_release
} ;

static void virtalchar_setup_cdev(void)
{
    int err, devno = MKDEV(virtualchar_major, 0) ;

    cdev_init(&dev.cdev, &virtualchar_fops) ;
    dev.cdev.owner = THIS_MODULE ;
    dev.cdev.ops = &virtualchar_fops ;

    err = cdev_add(&dev.cdev, devno, 1) ;
    if(err)
    {
        printk(KERN_NOTICE "Error %d adding globalmem", err) ;
    }
}

int virtualchar_init(void)
{
    int result ;
    dev_t devno = MKDEV(virtualchar_major, 0) ;

    if(virtualchar_major)
    {
        result = register_chrdev_region(devno, 1, "virtualchar") ;
    }else
    {
        result = alloc_chrdev_region(&devno, 0, 1, "virtualchar") ;
        virtualchar_major = MAJOR(devno) ;
    }

    if( result < 0)
    {
        return result ;
    }

    virtalchar_setup_cdev() ;/*对globalmem 设备进行设置，该函数应该是驱动自我完善的函数*/

    return 0 ;
    
}

void virtualchar_exit(void)
{
    cdev_del(&dev.cdev) ;
    unregister_chrdev_region(MKDEV(virtualchar_major, 0), 1) ;
}

MODULE_AUTHOR("cao bin xin") ;
MODULE_LICENSE("GPL") ;
module_param(virtualchar_major, int, S_IRUGO) ;

module_init(virtualchar_init) ;
module_exit(virtualchar_exit) ;