import { Navigate } from 'react-router-dom';
import type { ReactNode } from 'react';

function isAuthenticated() {
  // Example: check for a token or session (customize as needed)
  return !!sessionStorage.getItem('auth');
}

type PrivateRouteProps = {
  children: ReactNode;
};

export default function PrivateRoute({ children }: PrivateRouteProps) {
  return isAuthenticated() ? children : <Navigate to="/login" replace />;
}