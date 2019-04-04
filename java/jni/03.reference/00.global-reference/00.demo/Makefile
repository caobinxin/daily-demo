

all:
	echo "编译"
	javac JavaMain.java
	javah -o add_task.h JavaMain
	g++ -fPIC -fpermissive -c -I /usr/lib/jvm/java-8-openjdk-amd64/include/linux/ -I /usr/lib/jvm/java-8-openjdk-amd64/include  add_task.cpp -o add_task.o 
	g++ -shared -o libCAddTaskReturnJava_jni.so add_task.o
	sudo cp libCAddTaskReturnJava_jni.so /usr/lib/jni/
	echo "运行"
	java JavaMain
clean:
	sudo rm /usr/lib/jni/libCAddTaskReturnJava_jni.so
	rm add_task.h
	rm *.class *.o *.so