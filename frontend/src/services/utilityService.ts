import { apiClient } from './apiClient'
import type { ServiceArea } from '../types/serviceArea'
import type { ExternalEntity } from '../types/externalEntity'

export const getServiceAreas = () => 
    apiClient.get<ServiceArea[]>('/service-areas')

export const getServiceAreaById = (id: number) => 
    apiClient.get<ServiceArea>(`/service-areas/${id}`)

export const getExternalEntities = () => 
    apiClient.get<ExternalEntity[]>('/external-entities')

export const getExternalEntityById = (id: number) => 
    apiClient.get<ExternalEntity>(`/external-entities/${id}`)