#!/bin/bash
# get all filename in specified path

files=
read_one_file_name(){
	path=$1
	files=$(ls $path)
	return 1
}


echo "脚本输入的参数: $1 参数个数: $#"
echo "调用函数"
read_one_file_name ./
one=${files[0]}
echo "----------------"
echo "$one"
echo "$one.type"
echo "调用结束　输出　$1"
