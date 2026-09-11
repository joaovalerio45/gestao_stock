import { LanguageProvider } from './context/LanguageContext';
import { NavBar } from './components/Navbar';
import { Dashboard } from './pages/Dashboard';


export default function App() {
  return (
    <LanguageProvider>
        <NavBar />
        <main>
          <Dashboard/>
        </main>
    </LanguageProvider>
  );
}
