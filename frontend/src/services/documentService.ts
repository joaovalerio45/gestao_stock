import { apiClient } from './apiClient'
import type { Document, DocumentRequest, DocumentItemRequest, DocumentType } from '../types/document'

export const getDocuments = () => 
    apiClient.get<Document[]>('/documents')

export const getDocumentById = (id: number) => 
    apiClient.get<Document>(`/documents/${id}`)

export const createDocument = (doc: DocumentRequest) => 
    apiClient.post<Document>('/documents', doc)

export const updateDocumentItems = (id: number, items: DocumentItemRequest[]) => 
    apiClient.put<Document>(`/documents/${id}/items`, items)

export const getDocumentTypes = () => 
    apiClient.get<DocumentType[]>('/document-types')