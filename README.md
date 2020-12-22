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



##### CoroutineScopes:
Coroutine Scopes is an interface provides the scope of coroutine,
##### GlobalScopes:
we have another scope interface called global scope,
 global scope is used to launch top level coroutines which are operating on the whole application lifetime.
 Both of these scopes also acts as a reference to the coroutine context(like:Dispatchers.io)
 ### Dispatchers:
 **Dispatchers.Main**: To launch coroutines in the main thread we use, which in android we call it UI thread, we should only use this Dispatchers for small light weight task.
 **Dispatchers.io**: Coroutine will run in a background thread from a shared pool of on-demand created threads.we usually use this for local database or communicate with network and work with files
 **Dispatchers.Default**:  For CPU intensive tasks such as sorting a large list.
 **Dispatchers.Unconfined**: Coroutine will run in a the current thread, but if it suspended and resumed it will run on suspending function's thread. WARNING: it is not recommended to use this for android development.





 #### There are 4 main coroutine builder:  launch, async, produce, runBlocking.
 
 **Launch:** Launch builder launches a new coroutine without the current thread, This builder returns an instance of job,
  which can be used as a reference to the coroutine,
 We use this builder for coroutines  that doesn't have any result as the return value, it means we can't use this coroutines to calculate something and get the final answer as the return value.
 
 **Async:** If we want to get result as a return value we should use async coroutine builder but not only that the main specialty of async builder is that it allows us to launch coroutine in parallel,
  Async builder launches a new coroutine without blocking the current thread,
 This builder returns an instance of deferred<T\>. we need to invoke await() to get the value. We use this builder for coroutines that does have a result as the return value.
 
 **Produce:** Produce builder is for coroutines which produces a stream of elements,
This builder returns an instance of receiveChannel, The coroutine we create using this thread will block the thread while the coroutine is executing, And it returns a result of type T.

#### Suspending Functions:
In Kotlin Coroutines, whenever a coroutine is suspended, the current stack frame of the function is copied and saved in the memory.
When the function resumes after completing its task, the stack frame is copied back from where it was saved and starts running again.
Coroutines provides us a lot of functions to make our works easy,
Some example of Suspending Functions:
**withContext**
**withTimeot**
**withTimeoutOrNull**
**join**
**delay**
**await**
**supervisorScope**
**coroutineScope**

if we are going to use a suspending function such as withContext, we have to mark our calling function with suspend modifier
and also if we if we are going to invoke another suspending function created by us we have to also mark that calling function we suspend modifier,
With suspend modifier we are actually limiting the use of the function only for coroutines,
A suspending function can be called from coroutine block or from another suspending function only,
A suspending function, can be invoked from a coroutine block or from an another suspending function only.
A Coroutine can invoke both suspending and non suspending functions,
But a suspending function can be invoked from a coroutine block or from an other suspending function only.

So We use suspending function to avoid trip blocking and hence to provide a smooth uninterrupted expreince to our users.

## 35