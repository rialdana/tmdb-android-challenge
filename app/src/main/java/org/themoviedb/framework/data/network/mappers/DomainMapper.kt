package org.themoviedb.framework.data.network.mappers

interface DomainMapper<T : Any> {
    fun mapToDomainModel(): T
}