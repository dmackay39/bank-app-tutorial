import { NavLink } from 'react-router-dom'
import styles from './NavBar.module.css'

export default function NavBar() {
  return (
    <nav className={styles.navbar}>
      <div className={styles['navbar-title']}>Bank</div>
      <ul className={styles['navbar-tabs']}>
        <li>
          <NavLink to="/" className={({ isActive }) => isActive ? styles.active : undefined} end>
            Home
          </NavLink>
        </li>
        <li>
          <NavLink to="/accounts" className={({ isActive }) => isActive ? styles.active : undefined}>
            Your Accounts
          </NavLink>
        </li>
        <li>
          <NavLink to="/products" className={({ isActive }) => isActive ? styles.active : undefined}>
            Products
          </NavLink>
        </li>
        <li>
          <NavLink to="/about" className={({ isActive }) => isActive ? styles.active : undefined}>
            About
          </NavLink>
        </li>
        <li>
          <NavLink to="/login" className={styles['login-title']}>
            Login
          </NavLink>
        </li>
      </ul>
    </nav>
  )
}