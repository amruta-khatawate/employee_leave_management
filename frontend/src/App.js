import logo from './logo.svg';
import './App.css';
import React from 'react';
import Login from './components/Login';
import { BrowserRouter as Router, Routes , Route } from 'react-router-dom';
import EmployeeDashboard from './components/EmployeeDashboard';


function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Login />} />
        <Route path='/employee-dashboard' element={<EmployeeDashboard />} />
        <Route />
      </Routes>
    </Router>
  );
}

export default App;
