async function request<T>(endpoint: string, options?: RequestInit): Promise<T> {
    const response = await fetch(`/api${endpoint}`, {
        ...options,
        headers: {
            'Content-Type': 'application/json',
            ...options?.headers,
        },
    })

    if (!response.ok) {
        let errorMessage = `Erro HTTP ${response.status}`
        try {
            const errorData = await response.json()
            if (errorData.detail) errorMessage = errorData.detail
            else if (errorData.message) errorMessage = errorData.message
        } catch {
        }
        throw new Error(errorMessage)
    }

    if (response.status === 204) {
        return null as T
    }

    return response.json()
}

export const apiClient = {
  get: <T>(url: string) => 
    request<T>(url, { method: 'GET' }),

  post: <T>(url: string, body?: unknown) => 
    request<T>(url, { 
      method: 'POST', 
      body: body ? JSON.stringify(body) : undefined 
    }),

  put: <T>(url: string, body?: unknown) => 
    request<T>(url, { 
      method: 'PUT', 
      body: body ? JSON.stringify(body) : undefined 
    }),

  patch: <T>(url: string, body?: unknown) => 
    request<T>(url, { 
      method: 'PATCH', 
      body: body ? JSON.stringify(body) : undefined 
    }),
    
  delete: <T>(url: string) => 
    request<T>(url, { method: 'DELETE' }),
}