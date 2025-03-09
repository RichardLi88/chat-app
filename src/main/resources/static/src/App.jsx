import "./css/App.css";
import Login from "./login";
import { Route, Routes } from "react-router";
import HomeScreen from "./HomeScreen";
import { UserProvider } from "./contexts/UserContext";

function App() {
  return (
    <>
      <UserProvider>
        <Routes>
          <Route path="/" element={<Login />} />
          <Route path="/chat" element={<HomeScreen />} />
        </Routes>
      </UserProvider>
    </>
  );
}

export default App;
