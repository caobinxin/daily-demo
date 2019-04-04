all:
	echo "编译"
	javac HelloJni.java
	javah -o hellojni.h HelloJni
	gcc -fPIC -c -I /usr/lib/jvm/java-8-openjdk-amd64/include/linux/ -I /usr/lib/jvm/java-8-openjdk-amd64/include  hellojni.c -o hellojni.o
	gcc -shared -o libhello-jni.so hellojni.o
	sudo cp libhello-jni.so /usr/lib/jni/
	echo "运行"
	java HelloJni
clean:
	sudo rm /usr/lib/jni/libhello-jni.so
	rm hellojni.h
	rm *.class *.o *.so