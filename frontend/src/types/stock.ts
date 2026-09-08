import type { Warehouse } from './warehouse'
import type { Item } from './item'

export interface WarehouseStock {
  id: number
  warehouse: Warehouse
  item: Item
  currentStock: number
  minimumStock: number
}
