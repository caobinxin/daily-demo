处理git 大文件提交的方案：
参照这个网址：https://www.cnblogs.com/lout/p/6111739.html



第一步： 检测大文件
git verify-pack -v .git/objects/pack/pack-*.idx | sort -k 3 -g | tail -5

第二步： 找到大文件的对应的名字
git rev-list --objects --all | grep 8f10eff91bb6aa2de1f5d096ee2e1687b0eab007

第三步：删除大文件
git filter-branch --index-filter 'git rm --cached --ignore-unmatch <your-file-name>'
rm -rf .git/refs/original/
git reflog expire --expire=now --all
git fsck --full --unreachable
git repack -A -d
git gc --aggressive --prune=now
git push --force [remote] master
