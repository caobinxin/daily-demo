

all:
	echo "编译"
	javac JavaMain.java Father.java Son.java CCallJava.java ArraysJava.java
	javah -o c_call_java.h CCallJava
	javah -o c_call_java_array.h ArraysJava

	g++ -fPIC -std=c++11 -fpermissive -c -I /usr/lib/jvm/java-8-openjdk-amd64/include/linux/ -I /usr/lib/jvm/java-8-openjdk-amd64/include  c_call_java.cpp -o c_call_java.o 
	g++ -shared -o libCCallJava_jni.so c_call_java.o
	sudo cp libCCallJava_jni.so /usr/lib/jni/

	g++ -fPIC -std=c++11 -fpermissive -c -I /usr/lib/jvm/java-8-openjdk-amd64/include/linux/ -I /usr/lib/jvm/java-8-openjdk-amd64/include  c_call_java_array.cpp -o c_call_java_array.o 
	g++ -shared -o libCCallJavaArrays_jni.so c_call_java_array.o
	sudo cp libCCallJavaArrays_jni.so /usr/lib/jni/

	echo "运行"
	java JavaMain

	make clean
	
clean:
	sudo rm /usr/lib/jni/libCCallJava_jni.so
	sudo rm /usr/lib/jni/libCCallJavaArrays_jni.so
	rm *.class *.o *.so *.h *.log