import useFetch from '../../hooks/useFetch'
import styles from './Accounts.module.css'

type Account = {
  id: number
  balance: number
}

export default function Accounts() {
  const apiUrl = import.meta.env.VITE_API_URL
  const { data, error, loading } = useFetch<Account[]>(`${apiUrl}/api/current-accounts/1`)

  return (
    <div className={styles.container}>
      <h1 className={styles.heading}>Your Accounts</h1>
      {loading && <p>Loading accounts...</p>}
      {error && <p className={styles.error}>Error: {error}</p>}
      {data && data.length === 0 && <p>No accounts found.</p>}
      {data && data.length > 0 && (
        <ul className={styles.accountList}>
          {data.map(account => (
            <li key={account.id} className={styles.accountItem}>
              <div>
                <span className={styles.accountId}>Account #{account.id}</span>
                <span className={styles.balance}>Balance: ${account.balance.toFixed(2)}</span>
              </div>
              <button className={styles.transferBtn} disabled>
                Transfer
              </button>
            </li>
          ))}
        </ul>
      )}
    </div>
  )
}