import {Role} from '../role/role';

export class User {
  public id: number;
  public firstName: string;
  public lastName: string;
  public email: string;
  public password: string;
  public mobileNumber: string;
  public roles: Role[];
}
