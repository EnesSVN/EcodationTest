import { ToastContainer } from 'react-toastify';
import CreateUser from './pages/CreateUser';

function App() {
  return (
    <div >
      <ToastContainer
      position='top-right'
      autoClose={2000}
      hideProgressBar={false}
      newestOnTop={false}
      closeOnClick
      rtl={false}
      pauseOnFocusLoss
      pauseOnHover
      theme='colored'/>
      <CreateUser />
    </div>
  );
}

export default App;
