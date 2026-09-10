import { apiClient } from './apiClient'
import type { Request, RequestRequest } from '../types/request'

export const getRequests = () => 
    apiClient.get<Request[]>('/requests')

export const getRequestById = (id: number) => 
    apiClient.get<Request>(`/requests/${id}`)

export const createRequest = (request: RequestRequest) => 
    apiClient.post<Request>('/requests', request)

export const updateRequest = (id: number, request: RequestRequest) => 
    apiClient.put<Request>(`/requests/${id}`, request)

export const markPreparing = (id: number) => 
    apiClient.patch<Request>(`/requests/${id}/preparing`)

export const releasePreparing = (id: number) => 
    apiClient.patch<Request>(`/requests/${id}/release`)

export const cancelRequest = (id: number) => 
    apiClient.patch<Request>(`/requests/${id}/cancel`)