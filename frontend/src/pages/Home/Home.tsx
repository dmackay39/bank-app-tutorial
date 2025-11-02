import styles from './Home.module.css'

export default function Home() {
    return (
        <div className={styles.container}>
            <h1 className={styles.heading}>Home Page</h1>
            <p className={styles.welcome}>Welcome to the home page!</p>

            <section className={styles.section}>
                <h2 className={styles.sectionTitle}>News</h2>
                <ul className={styles.newsList}>
                    <li>New mobile app update released!</li>
                    <li>Branch opening in downtown next month.</li>
                    <li>Interest rates updated for savings accounts.</li>
                </ul>
            </section>

            <section className={styles.section}>
                <h2 className={styles.sectionTitle}>Our Mission</h2>
                <p>
                    To empower our customers with secure, innovative, and accessible financial solutions.
                </p>
            </section>

            <section className={styles.section}>
                <h2 className={styles.sectionTitle}>Our Vision</h2>
                <p>
                    To be the most trusted and customer-centric bank, leading the way in digital banking.
                </p>
            </section>

            <section className={styles.sectionAlert}>
                <h2 className={styles.sectionTitle}>Security Alerts</h2>
                <ul className={styles.alertList}>
                    <li>Beware of phishing emails. Never share your password.</li>
                    <li>Enable two-factor authentication for extra protection.</li>
                </ul>
            </section>
        </div>
    );
}