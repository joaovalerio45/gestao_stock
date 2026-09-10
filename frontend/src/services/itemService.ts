import { apiClient } from "./apiClient";
import type { Item, ItemRequest, Family, SubFamily, MeasurementUnit } from "../types/item";

export const getItems = () =>
    apiClient.get<Item[]>('/items')

export const getItemById = (id: number) => 
    apiClient.get<Item>(`/items/${id}`)

export const createItem = (item: ItemRequest) => 
    apiClient.post<Item>('/items', item)

export const updateItem = (id: number, item: ItemRequest) => 
    apiClient.put<Item>(`/items/${id}`, item)

export const toggleActiveItem = (id: number) => 
    apiClient.patch<Item>(`/items/${id}/toggle-active`)

export const getFamilies = () => 
    apiClient.get<Family[]>('/families')

export const getSubFamilies = () => 
    apiClient.get<SubFamily[]>('/sub-families')

export const getMeasurementUnits = () => 
    apiClient.get<MeasurementUnit[]>('/measurement-units')