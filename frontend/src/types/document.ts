import type { OperationType } from './enums'
import type { Warehouse } from './warehouse'
import type { ServiceArea } from './serviceArea'
import type { Item } from './item'
import type { ExternalEntity } from './externalEntity'
import type { Request } from './request'

export interface DocumentType {
  id: number
  code: string
  name: string
  operationType: OperationType
  stockMovementEnabled: boolean
  active: boolean
}

export interface DocumentItem {
  id: number
  item: Item
  quantity: number
  unitPriceExclVat: number
  vatRate: number
  unitPriceInclVat: number
  totalLineExclVat: number
  totalLineVat: number
  totalLineInclVat: number
}

export interface Document {
  id: number
  documentType: DocumentType
  operationType: OperationType
  year: number
  sequenceNumber: number
  internalDocumentNumber: string
  originDocumentNumber: string
  documentDate: string
  registrationDate: string
  originWarehouse: Warehouse | null
  originServiceArea: ServiceArea | null
  destinationWarehouse: Warehouse | null
  destinationServiceArea: ServiceArea | null
  items: DocumentItem[]
  externalEntity: ExternalEntity | null
  request: Request | null
  observations: string | null
}

export interface DocumentItemRequest {
  itemId: number
  quantity: number
  unitPriceExclVat?: number
  vatRate?: number
}

export interface DocumentRequest {
  documentTypeId: number
  originDocumentNumber: string
  documentDate: string
  originWarehouseId?: number
  originServiceAreaId?: number
  destinationWarehouseId?: number
  destinationServiceAreaId?: number
  items: DocumentItemRequest[]
  requestId?: number
  externalEntityId?: number
  observations?: string
}
