<?php
ob_start();
?>
<!DOCTYPE html>
<html>
    <head></head>
    <body>
        <h1> Nome Anno Paese Regista Link </h1>
        
        <?php
            include 'json_fake_db.php';
            $arr = ReadAllFilms();
            foreach($arr as $film=>$d) {
        ?>
        <form method="post" action="index.php">
                <input type="text" name="name" value="<?php echo $film ?>" placeholder="Nome"/>
                <input type="hidden" name="oldName" value="<?php echo $film ?>" />
                <input type="text" name="year" value="<?php echo $d["anno"] ?>" placeholder="Anno"/>
                <input type="text" name="region" value="<?php echo $d["paese"] ?>" placeholder="Paese"/>
                <input type="text" name="producer" value="<?php echo $d["regista"] ?>" placeholder="Regista"/>
                <input type="text" name="link" value="<?php echo $d["link"] ?>" placeholder="Link"/>
                <?php 
                    if($d["link"]!="") {
                ?>
                <button><a href="<?php echo $d["link"] ?>">Link</a></button>
                <?php
                    }
                ?>
                <input type="submit" name="edit" value="Modifica"/>
                <input type="submit" name="delete" value="Cancella"/>
                
        </form>
        <br>
        
        <?php
            }
        ?>
        <form method="post" action="index.php">
            <input type="text" name="name" placeholder="Nome"/>
            <input type="text" name="year" placeholder="Anno"/>
            <input type="text" name="region" placeholder="Paese"/>
            <input type="text" name="producer" placeholder="Regista"/>
            <input type="text" name="link" placeholder="Link"/>
            <input type="submit" name="add" value="Inserisci"/>
            </form>
    </body>
    <?php 
        if(isset($_POST["add"])) {
            $details = array("anno"=>$_POST["year"], "paese"=>$_POST["region"], "regista"=>$_POST["producer"], "link"=>$_POST["link"]);
            $name = $_POST["name"];
            CreateFilm($name, $details);
            header("Location: index.php");
        }
        if(isset($_POST["delete"])) {
            DeleteFilm($_POST["name"]);
            header("Location: index.php");
        }
        if(isset($_POST["edit"])) {
            $details = array("anno"=>$_POST["year"], "paese"=>$_POST["region"], "regista"=>$_POST["producer"], "link"=>$_POST["link"]);
            UpdateFilm($_POST["oldName"], $_POST["name"], $details);
            header("Location: index.php");
        }
    ?>
</html>