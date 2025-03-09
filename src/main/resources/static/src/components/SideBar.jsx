import { Button, Flex, Text } from "@mantine/core";
import styles from "../css/General.module.css";
import ProfileCard from "./ProfileCard";
//test names
const names = [
  "John Doe",
  "Jane Mol",
  "Alex Lump",
  "Sarah Condor",
  "Mike Johnson",
  "Kate Kok",
  "Tom Smith",
];

function SideBar() {
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
        <Text ta="center" size="xl" fw={700}>
          Online now!
        </Text>
        <Flex direction="column" justify="start" flex="1">
          {names.map((name) => {
            return <ProfileCard key={name} name={name} />;
          })}
        </Flex>
        <Button m="10px">Logout</Button>
      </Flex>
    </>
  );
}

export default SideBar;
