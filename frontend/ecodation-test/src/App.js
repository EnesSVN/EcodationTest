import { ToastContainer } from "react-toastify";
import CustomNavbar from "./components/CustomNavbar";
import CreateUser from "./pages/CreateUser";
import ListUser from "./pages/ListUser";
import { Routes, Route } from "react-router-dom";

function App() {
  return (
    <>
      <CustomNavbar />
      <ToastContainer
        position="top-right"
        autoClose={2000}
        hideProgressBar={false}
        newestOnTop={false}
        closeOnClick
        rtl={false}
        pauseOnFocusLoss
        pauseOnHover
        theme="colored"
      />
      <Routes>
        <Route path="/" element={<ListUser />} />
        <Route path="/create" element={<CreateUser />} />
      </Routes>
    </>
  );
}

export default App;
