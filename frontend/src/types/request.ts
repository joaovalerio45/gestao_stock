import type { RequestState } from './enums'
import type { ServiceArea } from './serviceArea'
import type { Warehouse } from './warehouse'
import type { Item } from './item'

export interface RequestItem {
  id: number
  item: Item
  requestedQuantity: number
  fulfilledQuantity: number
}

export interface Request {
  id: number
  number: string
  serviceArea: ServiceArea
  warehouse: Warehouse
  requestDate: string
  fulfillmentDate: string | null
  state: RequestState
  items: RequestItem[]
  requestNotes: string | null
  deliveryNotes: string | null
}

export interface RequestItemRequest {
  itemId: number
  requestedQuantity: number
}

export interface RequestRequest {
  serviceAreaId: number
  warehouseId: number
  items: RequestItemRequest[]
  requestNotes?: string
}
