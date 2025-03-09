import { Button, Flex, ScrollArea, Text } from "@mantine/core";
import styles from "../css/General.module.css";
import ProfileCard from "./ProfileCard";
import { useContext } from "react";
import { UserContext } from "../contexts/UserContext";
import { useNavigate } from "react-router";
//test names
const names = [
  "John Doe",
  "Jane Mol",
  "Alex Lump",
  "Sarah Condor",
  "Mike Johnson",
  "Kate Kok",
  "Tom Smith",
  "Name 1",
  "Name 2",
  "Name 3",
  "Name 4",
  "Name 5",
  "Name 6",
  "Name 7",
  "Name 8",
  "Name 9",
];

function SideBar() {
  //variables to handle logging out
  const { setUser } = useContext(UserContext);
  const navigate = useNavigate();

  function handleLogout() {
    setUser({});
    navigate("/", { replace: true });
  }

  return (
    <>
      <Flex
        direction="column"
        h="100%"
        className={styles["right-shadow"]}
        w="20%"
        onClick={() => {
          console.log("clicked");
        }}
      >
        <Text ta="center" size="xl" fw={700} h="100px">
          Online now!
        </Text>
        <Flex direction="column" justify="start" flex="1" mah="85%">
          <ScrollArea>
            {names.map((name) => {
              return <ProfileCard key={name} name={name} />;
            })}
          </ScrollArea>
        </Flex>
        <Button m="10px" h="100px" onClick={handleLogout}>
          Logout
        </Button>
      </Flex>
    </>
  );
}

export default SideBar;
