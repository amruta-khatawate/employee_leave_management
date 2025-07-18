import React from 'react'

function EmployeeDashboard() {
  return (
    <div className='dashboard-container'>
      <h2> Employee Dashboard</h2>

      <table>
            <thead>
                  <tr>
                        <th>S.No</th>
                        <th>Emp ID</th>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Role</th>
                        <th>Actions</th>
                  </tr>
            </thead>

            <tbody>
                  <tr>
                        <td>1</td>
                        <td>2853561</td>
                        <td>Amruta</td>
                        <td>amruta@tcs.com</td>
                        <td>Employee</td>
                        <td>
                              <button>View</button>
                        </td>
                  </tr>
            </tbody>
      </table>
    </div>
    
  )
}

export default EmployeeDashboard