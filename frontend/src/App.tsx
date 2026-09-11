import { LanguageProvider } from './context/LanguageContext';
import { NavBar } from './components/Navbar';


export default function App() {
  return (
    <LanguageProvider>
        <NavBar />
    </LanguageProvider>
  );
}
