import { createContext, useContext, useState, type ReactNode } from "react";
import { type Language, translations } from "../i18n/translations";


interface LanguageContextType{
    language : Language;
    toggleLanguage : () => void;
    t: typeof translations['pt'];
}

const LanguageContext = createContext<LanguageContextType | undefined>(undefined);

interface LanguageProviderProp{
    children: ReactNode;
}

export function LanguageProvider({children}:LanguageProviderProp){

    const [language, setLanguage] = useState<Language>('pt')

    const toggleLanguage = () => {
        setLanguage((prev) => (prev == 'pt' ? 'en' : 'pt'))
    }

    const t = translations[language];

    return (
        <LanguageContext.Provider value = {{language, toggleLanguage, t}}>
         {children}
        </LanguageContext.Provider>)

    
}

export function useLanguage() {
  const context = useContext(LanguageContext);
  if (!context) {
    throw new Error('useLanguage must be used within a LanguageProvider');
  }
  return context;
}