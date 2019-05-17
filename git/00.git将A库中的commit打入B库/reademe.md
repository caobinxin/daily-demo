参照:https://www.cnblogs.com/huangtailang/p/4730336.html

第一步：　创建测试提交记录

第二步：  合并

    将Ｂ作为 A 的远端仓库
        【colby@pc:~/work/daily-demo/git/00.git将A库中的commit打入B库/A$】 git remote add B ../B

    获取Ｂ仓库中的所有信息　--a 代表获取D2仓库的所有分支和tag等信息(合并前请尽量保持一个分支，否则合并后提交记录不忍直视)
        【colby@pc:~/work/daily-demo/git/00.git将A库中的commit打入B库/A$】 git fetch --all

    此时的分支状态:
        【colby@pc:~/work/daily-demo/git/00.git将A库中的commit打入B库/A$】 git branch -a
            * master
              remotes/B/master

    切换分支
        【colby@pc:~/work/daily-demo/git/00.git将A库中的commit打入B库/A$】 git checkout -b B/master B/master 
            分支 'B/master' 设置为跟踪来自 'B' 的远程分支 'master'。
            切换到一个新分支 'B/master'

    **其实针对内核升级中，将社区的kernel 4.19中的提交记录,保存在我们的项目中，执行在这里就可以了，此时就会在项目中出现一个新的分支**


    切到A的主分支，进行合并操作
    

    