import * as React from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import Container from '@mui/material/Container';
import Paper from '@mui/material/Paper';
import {useState }from 'react';
import Button from '@mui/material/Button';

export default function Song() {

    const paperStyle = {padding: '50px 20px', width:600, margin: "20px auto"}
    const [songName,setSongName] = useState('Krab')
    const [songLength,setSongLength] = useState('')
    const [songDescription,setSongDescription] = useState('')
    const [songCreatedAt, setSongCreatedAt] = useState('')

    const handleClick = (e)=>{
    e.preventDefault()
    const song={songName,songLength,songDescription, songCreatedAt}
    console.log(song)
    fetch("http://localhost:8082/songs",{
    method:"POST",
    headers:{"Content-Type":"application/json"},
    body:JSON.stringify(song)
    }).then(()=> {
    console.log("New Song added")
    })
    }

  return (
    <Box
      component="form"
      sx={{
        '& > :not(style)': { m: 3, width: '25ch' },
      }}
      noValidate
      autoComplete="off"
    >
    <Container>
        <Paper elevation={5} style={paperStyle}>
                <h1 style={{color:"green"}}>  <u>Add Song</u>  </h1>


                    <TextField id="outlined-basic" label="Song Name" variant="outlined" fullWidth
                    value = {songName}
                    onChange={(e)=>setSongName(e.target.value)}
                    />

                    <TextField id="outlined-basic" label="Song Length" variant="outlined" fullWidth
                    value = {songLength}
                    onChange={(e)=>setSongLength(e.target.value)}
                    />

                    <TextField id="outlined-basic" label="Song Description" variant="outlined" fullWidth
                    value = {songDescription}
                    onChange={(e)=>setSongDescription(e.target.value)}
                    />

                    <TextField id="outlined-basic" label="Song Creation Date" variant="outlined" fullWidth
                    value = {songCreatedAt}
                    onChange={(e)=>setSongCreatedAt(e.target.value)}
                    />

                    <Button variant="contained" color= "secondary" onClick={handleClick}>
                    Submit
                    </Button>

        </Paper>
    </Container>

    </Box>
  );
}
