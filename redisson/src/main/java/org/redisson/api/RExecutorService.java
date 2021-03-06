/**
 * Copyright 2016 Nikita Koksharov
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.redisson.api;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/**
 * Distributed implementation of {@link java.util.concurrent.ExecutorService}
 * 
 * @author Nikita Koksharov
 *
 */
public interface RExecutorService extends ExecutorService, RExecutorServiceAsync {

    /**
     * Submits a value-returning task for execution and returns a
     * Future representing the pending results of the task. The
     * Future's {@code get} method will return the task's result upon
     * successful completion.
     *
     * @param task the task to submit
     * @param <T> the type of the task's result
     * @return a Future representing pending completion of the task
     */
    @Override
    <T> RFuture<T> submit(Callable<T> task);
    
    /**
     * Submits a Runnable task for execution and returns a Future
     * representing that task. The Future's {@code get} method will
     * return the given result upon successful completion.
     *
     * @param task the task to submit
     * @param result the result to return
     * @param <T> the type of the result
     * @return a Future representing pending completion of the task
     */
    @Override
    <T> RFuture<T> submit(Runnable task, T result);;

    /**
     * Submits a Runnable task for execution and returns a Future
     * representing that task. The Future's {@code get} method will
     * return {@code null} upon <em>successful</em> completion.
     *
     * @param task the task to submit
     * @return a Future representing pending completion of the task
     */
    @Override
    RFuture<?> submit(Runnable task);

    /**
     * Returns executor name
     * 
     * @return name of service
     */
    String getName();
    
    /**
     * Deletes executor request queue and state objects
     * 
     * @return <code>true</code> if any of objects were deleted
     */
    boolean delete();

    /**
     * Register workers
     * 
     * @param workers - workers amount
     */
    void registerWorkers(int workers);
    
    /**
     * Register workers with custom executor which executes each task
     * 
     * @param workers - workers amount
     * @param executor - executor instance
     */
    void registerWorkers(int workers, ExecutorService executor);

}
