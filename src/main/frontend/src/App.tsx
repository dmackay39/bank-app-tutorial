import { Routes, Route } from 'react-router-dom'
import './App.css'
import Home from './pages/Home'
import NavBar from './components/NavBar'
import Accounts from './pages/Accounts/Accounts'
import PrivateRoute from './components/PrivateRoute/PrivateRoute'
import Login from './pages/Login'

function App() {
  return (
    <>
      <NavBar />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/about" element={<div>About Page</div>} />
        <Route path="/contact" element={<div>Contact Page</div>} />
        <Route path="/accounts" element={
          <PrivateRoute>
            <Accounts />
          </PrivateRoute>
        } />
        <Route path="/login" element={<Login />} />
      </Routes>
    </>
  );
}

export default App