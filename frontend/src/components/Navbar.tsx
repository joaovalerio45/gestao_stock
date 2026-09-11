import { Warehouse, Globe, User } from "lucide-react";
import { useLanguage } from "../context/LanguageContext";
import { NavLink } from "react-router-dom";

export function NavBar(){

    const { language, toggleLanguage, t } = useLanguage();

    return (
        <nav className="bg-white border-b-2 border-gray-200 shadow-xs sticky top-0 z-50">
            <div className="w-full px-4 sm:px-6 lg:px-8 py-3.5 flex items-center justify-between">
                
                {/* 1. Left: Brand & App Title (Protected from shrinking) */}
                <div className="flex items-center gap-3.5 shrink-0">
                    <div className="p-3 bg-blue-50 text-blue-600 rounded-xl">
                        <Warehouse className="w-10 h-10"/>
                    </div>
                    <div>
                        <span className="font-bold text-2xl text-gray-900 leading-tight block whitespace-nowrap">
                            {t.appTitle}
                        </span>
                        <span className="block text-sm text-gray-500 font-medium whitespace-nowrap">
                            {t.appSubtitle}
                        </span>
                    </div>
                </div>

                {/* 2. Middle: Navigation Links in Segmented Pill */}
                <div className="flex items-center gap-1.5 bg-gray-100/80 p-1.5 rounded-xl border border-gray-200/80">
                    <NavLink
                        to="/"
                        className={({ isActive }) =>
                            `px-4 py-2 rounded-lg text-base font-bold transition-all ${
                                isActive
                                    ? 'bg-white text-blue-600 shadow-xs'
                                    : 'text-gray-600 hover:text-gray-900 hover:bg-white/50'
                            }`
                        }
                    >
                        {t.dashboard}
                    </NavLink>

                    <NavLink 
                        to="/stock"
                        className={({ isActive }) => 
                            `px-4 py-2 rounded-lg text-base font-bold transition-all ${
                                isActive
                                    ? 'bg-white text-blue-600 shadow-xs'
                                    : 'text-gray-600 hover:text-gray-900 hover:bg-white/50'
                            }`
                        }
                    >
                        {t.stock}
                    </NavLink>

                    <NavLink 
                        to="/requests"
                        className={({ isActive }) => 
                            `px-4 py-2 rounded-lg text-base font-bold transition-all ${
                                isActive
                                    ? 'bg-white text-blue-600 shadow-xs'
                                    : 'text-gray-600 hover:text-gray-900 hover:bg-white/50'
                            }`
                        }
                    >
                        {t.requests}
                    </NavLink>

                    <NavLink 
                        to="/documents"
                        className={({ isActive }) => 
                            `px-4 py-2 rounded-lg text-base font-bold transition-all ${
                                isActive
                                    ? 'bg-white text-blue-600 shadow-xs'
                                    : 'text-gray-600 hover:text-gray-900 hover:bg-white/50'
                            }`
                        }
                    >
                        {t.documents}
                    </NavLink>

                    <NavLink 
                        to="/items"
                        className={({ isActive }) => 
                            `px-4 py-2 rounded-lg text-base font-bold transition-all ${
                                isActive
                                    ? 'bg-white text-blue-600 shadow-xs'
                                    : 'text-gray-600 hover:text-gray-900 hover:bg-white/50'
                            }`
                        }
                    >
                        {t.items}
                    </NavLink>
                </div>

                {/* 3. Right: Language Switcher + User Profile */}
                <div className="flex items-center gap-4">
                    <button
                        onClick={toggleLanguage}
                        className="flex items-center gap-2.5 px-3.5 py-2 rounded-xl border border-gray-200 text-sm
                            font-bold text-gray-700 hover:bg-gray-50 hover:border-gray-300 transition-colors
                            cursor-pointer shadow-xs"
                        title="Mudar Idioma / Toggle Language"
                    >
                        <Globe className="w-5 h-5 text-gray-500"/>
                        <span className="bg-blue-50 text-blue-600 px-2 py-0.5 rounded-md text-xs font-bold tracking-wider">
                            {language.toUpperCase()}
                        </span>
                    </button>

                    {/* User Profile Pill */}
                    <div className="flex items-center gap-3 pl-3 border-l border-gray-200 shrink-0">
                        <div className="w-10 h-10 rounded-full bg-blue-600 text-white flex items-center justify-center font-bold text-base shadow-xs shrink-0">
                            <User className="w-5 h-5 text-white"/>
                        </div>
                        <div className="hidden xl:block text-left">
                            <span className="block text-sm font-bold text-gray-900 leading-tight whitespace-nowrap">
                                João Valério
                            </span>
                            <span className="block text-xs text-gray-400 font-medium whitespace-nowrap">
                                {language === 'pt' ? 'Gestor de Armazém' : 'Warehouse Manager'}
                            </span>
                        </div>
                    </div>
                </div>

            </div>
        </nav>
    );

}


