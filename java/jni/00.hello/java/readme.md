
#### 编译说明
# -d ./ 会在当前目录下生成 package com.example.hellojni;所对应的目录
cbx-study/java/jni/00.hello/java$ javac -d ./ HelloJni.java 
cbx-study/java/jni/00.hello/java$ tree
.
├── com
│   └── example
│       └── hellojni
│           └── HelloJni.class
└── HelloJni.java

cbx-study/java/jni/00.hello/java$ javah -o output.h com.example.hellojni.HelloJni
cbx-study/java/jni/00.hello/java$ tree
.
├── com
│   └── example
│       └── hellojni
│           └── HelloJni.class
├── HelloJni.java
└── output.h

3 directories, 3 files