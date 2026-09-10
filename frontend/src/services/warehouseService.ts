import { apiClient } from "./apiClient";
import type { Warehouse } from "../types/warehouse";
import type { WarehouseStock } from "../types/stock";

export const getWarehouses = () => 
    apiClient.get<Warehouse[]>('/warehouses')

export const getWarehouseById = (id: number) => 
  apiClient.get<Warehouse>(`/warehouses/${id}`)

export const getWarehouseStock = (warehouseId : number) => 
    apiClient.get<WarehouseStock[]>(`/warehouse-stocks/${warehouseId}`)

export const getWarehouseStockByItem = (warehouseId : number, itemId : number) =>
    apiClient.get<WarehouseStock>(`/warehouse-stocks/${warehouseId}/items/${itemId}`)

