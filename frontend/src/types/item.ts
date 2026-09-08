export interface MeasurementUnit {
  id: number
  abbreviation: string
  name: string
  allowsDecimals: boolean
  active: boolean
}

export interface Family {
  id: number
  code: string
  name: string
  active: boolean
}

export interface SubFamily {
  id: number
  family: Family
  code: string
  name: string
  active: boolean
}

export interface Item {
  id: number
  code: string
  name: string
  description: string | null
  subFamily: SubFamily
  measurementUnit: MeasurementUnit
  lastPriceNoVat: number | null
  vatRate: number
  active: boolean
}

export interface ItemRequest {
  code: string
  name: string
  subFamilyId: number
  measurementUnitId: number
  description?: string
  vatRate?: number
}

