package com.molochkov.ringtestmvp.core.network

/**
 * provides network services
 */
interface ServiceProvider {

    /**
     * creates API service class
     * @param serviceClass type of service to create
     * @return Api service class instance
     */
    fun <S> createService(serviceClass: Class<S>): S
}