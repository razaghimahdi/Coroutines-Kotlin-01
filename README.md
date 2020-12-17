# Coroutines-Kotlin-01

### Developed by Mahdi Razzaghi Ghaleh
This a Coroutines example tutorial for kotlin


#### What are Coroutines?
Kotlin Coroutines is the latest most efficient and most effective way up asynchorous programming and multi-threading in android development.
some popular things in Coroutines:
###### Coroutine Scopes
###### Dispatchers
###### Coroutine Builders
###### Suspending Functions
###### WithContext & Delay
###### Async & Await

In computer science there are two types of multitasking methods to manage multiple
concurrent procresses in one type the operating system controls to switch between procresses
 the other type is called coopretaive multitasking in which procresses control thier
  behavior by themselves coroutines are software components that creates subroutines for coopreative multitasking.

Coroutines were first used in 1958 for the assembly language such as python, c#.

In kotlin the coroutine can be introduced as a squence of well managed sub tasks.

To some extent a coroutine can be considered as a light weight thread.

Even you can execute many coroutines in a single thread.

A coroutines cam switch between threads which means a coroutins can supend from one thread and resume from another thread
We before used multi-treading task with java AsyncTask,Executer, HandlerThreads, IntentService AND RxJava, which those are can be easily repleaces with Coroutines.

Coroutines API allows us to write asynchorous codes in a sequential manner.

It avoids unnecessary boilerplate codes comes with callbacks.

Coroutines makes our code more readable and maintainable.

#### Why do we need asynchorous programming?
default android main thread has the set of regular responsibilities it has to always :
###### Pars XML
###### Inflate Views
###### Draw the screen
###### Listen to users such as click evens
So if we add more tasks to the main thread it could be app show Performance Errors, Freeze the screen, Unpredictable Behaviors,
so we should always implement long running tasks asynchronously in a separate thread which Coroutines is the best way.
