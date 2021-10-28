FROM postgres:latest

# get username and password from environmental variables (these can be set with a shell script)

# server must run on port 4040, serving on port 4050

# set work dir
# Copy the project files into the image 
# could copy the shell script into too.
WORKDIR /psql/datafiles
COPY . .

# have a run command that runs a shell script that configures everything?