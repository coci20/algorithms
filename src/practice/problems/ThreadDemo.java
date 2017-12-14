/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice.problems;

/**
 *
 * @author prasannjitk
 */
class ThreadDemo implements Runnable {
	String name;
	ThreadDemo(String s) {
		name = s;
	}
	@Override
	public void run() {
            System.out.println(this.name + " is running!");
            if(this.name.contains("1"))	f1();
            if(this.name.contains("2"))	f2();
            if(this.name.contains("3"))	f3();
            synchronized(this) {
                    try {
                            this.wait(1000);
                    } 
                    catch(InterruptedException e) {	
                        System.out.println(e.getMessage() + 
                                " exception occured");	}
            }
	}
	public void f1() {	System.out.println("f1() running");	}
	public void f2() {	System.out.println("f2() running");	}
	public void f3() {	System.out.println("f3() running");	}
	public static void main(String[] args) {
            ThreadDemo d1 = new ThreadDemo("thread1");
            ThreadDemo d2 = new ThreadDemo("thread2");
            ThreadDemo d3 = new ThreadDemo("thread3");
            Thread t = new Thread(d1);
            t.start();
            t = new Thread(d2);
            t.start();
            t = new Thread(d3);
            t.start();		
	}
}

/*
we are using Runnable interface here. Since this enables our class
to extend other classes. To create a thread, create a runnable object
ie object of the class implementing the runnable interface and
implement the run() method, with @override notation. to spawn the
thread simply call start() which implicitly calls the run() and exits.

Thread : independent path of execution within a program.
Properties: threads share address space, so the code and data
is shared between threads belonging to the same program.
helps in context switching and inter-thread communications
---lightweight in nature!

Having multiple tasks getting performed within a single program
is referred to as multithreading!

Exception caused - InterruptedException!!
*/
