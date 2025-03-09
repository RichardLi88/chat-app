import "./css/App.css";
import Login from "./login";
import { Route, Routes } from "react-router";
import HomeScreen from "./HomeScreen";

function App() {
  return (
    <>
      <Routes>
        <Route path="/" element={<Login />} />
        <Route path="/chat" element={<HomeScreen />} />
      </Routes>
    </>
  );
}

export default App;
