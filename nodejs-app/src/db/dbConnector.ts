import mysql, {Pool} from "promise-mysql";
import env from 'dotenv'


env.config();

export let dataSourse:Pool;
(async function initPool(){

    dataSourse =await mysql.createPool({
        host:process.env.DB_HOST,
        port:+process.env.DB_PORT!,
        database:process.env.DB_NAME,
        user:process.env.DB_USERNAME,
        password:process.env.DB_PASSWORD,
        connectionLimit:+process.env.DB_SIZE!
    })

})();