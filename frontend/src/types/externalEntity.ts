import type { EntityType } from './enums'

export interface ExternalEntity {
  id: number
  code: string
  name: string
  abbreviation: string
  nif: string | null
  type: EntityType
  active: boolean
}
