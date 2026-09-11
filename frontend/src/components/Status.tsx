import { useLanguage } from "../context/LanguageContext";
import type { RequestState } from "../types/enums";

interface StatusProps {
    status: RequestState | 'ACTIVE' | 'INACTIVE' | boolean;
}

export function Status({status}:StatusProps){
    const { t } = useLanguage();

    const key = typeof status == 'boolean' ? (status ? 'ACTIVE' : 'INACTIVE') : status;

    const config = {
        PENDING: {
            label: t.pending,
            badge: 'bg-amber-50 text-amber-700 border-amber-200'
        },

        PREPARING: {
            label: t.preparing,
            badge: 'bg-blue-50 text-blue-700 border-blue-200',
        },

        FULFILLED: {
            label: t.fulfilled,
            badge: 'bg-green-50 text-green-700 border-green-200',
        },

        CANCELED: {
            label: t.canceled,
            badge: 'bg-red-50 text-red-700 border-red-200',
        },

        ACTIVE: {
            label: t.active,
            badge: 'bg-emerald-50 text-emerald-700 border-emerald-200',
        },

        INACTIVE: {
            label: t.inactive,
            badge: 'bg-gray-100 text-gray-600 border-gray-200',
        }
    } 

    const current = config[key];
    return (
        <span className={`inline-flex items-center px-2.5 py-1 rounded-full text-xs font-bold border ${current.badge}`}>
        {current.label}
        </span>
    );
}