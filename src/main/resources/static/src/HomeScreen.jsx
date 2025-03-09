import MessageDisplay from "./components/MessageDisplay";
import SideBar from "./components/SideBar";
import styles from "./css/General.module.css";
import { Flex, Title } from "@mantine/core";

function HomeScreen() {
  return (
    <>
      <Flex
        w="100vw"
        h="100vh"
        justify="center"
        align="center"
        direction="column"
      >
        <Title>Welcome to Online Chat!</Title>
        <Flex
          w="80%"
          h="80%"
          miw="350px"
          className={styles["box-shadow"]}
          gap="10px"
        >
          <SideBar />
          <MessageDisplay />
        </Flex>
      </Flex>
    </>
  );
}

export default HomeScreen;
