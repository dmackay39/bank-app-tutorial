import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import styles from './Login.module.css';

export default function Login() {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [error, setError] = useState('');
    const navigate = useNavigate();

    const handleSubmit = async (e: React.FormEvent) => {
        e.preventDefault();
        setError('');
        const response = await fetch(import.meta.env.VITE_API_URL + '/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded',
            },
            credentials: 'include',
            body: new URLSearchParams({ username, password }).toString(),
        });
        if (response.ok) {
            sessionStorage.setItem('auth', 'true');
            navigate('/');
        } else {
            setError('Invalid username or password');
        }
    };

    return (
        <div className={styles.container}>
            <h1 className={styles.heading}>Login to Your Account</h1>
            <form onSubmit={handleSubmit} className={styles.form}>
                <div className={styles.inputGroup}>
                    <label className={styles.label}>
                        Username
                        <br/>
                        <input
                            className={styles.input}
                            type="text"
                            value={username}
                            onChange={e => setUsername(e.target.value)}
                            required
                            autoFocus
                        />
                    </label>
                </div>
                <div className={styles.inputGroup}>
                    <label className={styles.label}>
                        Password
                        <br/>
                        <input
                            className={styles.input}
                            type="password"
                            value={password}
                            onChange={e => setPassword(e.target.value)}
                            required
                        />
                    </label>
                </div>
                <button type="submit" className={styles.button}>Login</button>
                {error && <p className={styles.error}>{error}</p>}
            </form>
        </div>
    );
}