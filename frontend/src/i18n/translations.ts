export type Language = 'pt' | 'en'

export const translations = {
  pt: {
    // Navigation & App
    appTitle: 'Gestão de Stock',
    appSubtitle: 'Sistema de Gestão & Armazém',
    dashboard: 'Visão Geral',
    warehouses: 'Armazéns',
    stock: 'Stock Armazém',
    requests: 'Requisições',
    documents: 'Documentos',
    items: 'Artigos',

    // States
    pending: 'Pendente',
    preparing: 'Em Preparação',
    fulfilled: 'Concluído',
    canceled: 'Cancelado',
    active: 'Ativo',
    inactive: 'Inativo',

    // Actions
    new: 'Novo',
    create: 'Criar',
    edit: 'Editar',
    save: 'Guardar',
    cancel: 'Cancelar',
    delete: 'Eliminar',
    refresh: 'Atualizar',
    search: 'Pesquisar...',
    filter: 'Filtrar',
    selectWarehouse: 'Selecione um armazém...',
    startPreparing: 'Preparar',
    releasePreparing: 'Abandonar',
    fulfillRequest: 'Entregar',
    toggleActive: 'Alterar Estado',

    // Document & Operation Types
    entry: 'Entrada',
    withdrawal: 'Saída',
    transfer: 'Transferência',
    request: 'Requisição',

    // Table Headers & Labels
    code: 'Código',
    name: 'Nome',
    description: 'Descrição',
    unit: 'Unidade',
    family: 'Família',
    subFamily: 'Sub-Família',
    vatRate: 'Taxa IVA',
    lastPrice: 'Último Preço',
    currentStock: 'Stock Atual',
    minimumStock: 'Stock Mínimo',
    address: 'Morada',
    number: 'Número',
    date: 'Data',
    origin: 'Origem',
    destination: 'Destino',
    serviceArea: 'Área de Serviço',
    externalEntity: 'Entidade',
    actions: 'Ações',
    observations: 'Observações',
    requestedQty: 'Quantidade Pedida',
    fulfilledQty: 'Quantidade Entregue',

    // Status Messages
    loading: 'A carregar dados...',
    noData: 'Sem registos encontrados.',
    errorOccurred: 'Ocorreu um erro ao carregar os dados.',
  },
  en: {
    // Navigation & App
    appTitle: 'Stock Management',
    appSubtitle: 'Warehouse & Inventory System',
    dashboard: 'Dashboard',
    warehouses: 'Warehouses',
    stock: 'Warehouse Stock',
    requests: 'Requests',
    documents: 'Documents',
    items: 'Items',

    // States
    pending: 'Pending',
    preparing: 'In Preparation',
    fulfilled: 'Fulfilled',
    canceled: 'Canceled',
    active: 'Active',
    inactive: 'Inactive',

    // Actions
    new: 'New',
    create: 'Create',
    edit: 'Edit',
    save: 'Save',
    cancel: 'Cancel',
    delete: 'Delete',
    refresh: 'Refresh',
    search: 'Search...',
    filter: 'Filter',
    selectWarehouse: 'Select a warehouse...',
    startPreparing: 'Prepare',
    releasePreparing: 'Release',
    fulfillRequest: 'Fulfill',
    toggleActive: 'Toggle Active',

    // Document & Operation Types
    entry: 'Entry',
    withdrawal: 'Withdrawal',
    transfer: 'Transfer',
    request: 'Request',

    // Table Headers & Labels
    code: 'Code',
    name: 'Name',
    description: 'Description',
    unit: 'Unit',
    family: 'Family',
    subFamily: 'Sub-Family',
    vatRate: 'VAT Rate',
    lastPrice: 'Last Price',
    currentStock: 'Current Stock',
    minimumStock: 'Min Stock',
    address: 'Address',
    number: 'Number',
    date: 'Date',
    origin: 'Origin',
    destination: 'Destination',
    serviceArea: 'Service Area',
    externalEntity: 'External Entity',
    actions: 'Actions',
    observations: 'Observations',
    requestedQty: 'Requested Qty',
    fulfilledQty: 'Fulfilled Qty',

    // Status Messages
    loading: 'Loading data...',
    noData: 'No records found.',
    errorOccurred: 'An error occurred while loading data.',
  },
}

