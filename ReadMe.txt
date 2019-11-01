add file at root (project) level called it: proxy.conf.json
this file tells ng-java script server if sees any request that begin with
/server then forward them to targer on port 8080{
	{
  "/server": {
    "target": "http://localhost:8080",
    "secure": false,
    "changeOrigin": true,
    "logLevel": "debug",
    "pathRewrite": {
      "^/server" : ""
    }
  }
}

-Now edit package.json file ther is a start command and append 
the name of the file just created.  like so:
	"start": "ng serve --proxy-config proxy.conf.json",
 restart the npm and you will see  ng serve --proxy-config proxy.conf.json
 the new api url to be "localhost:4200/server/api/v1/bikes my case is
 http://localhost:4200/litas/orders and from angular app logs look like so:
   Angular Live Development Server is listening on localhost:4200, open your browser on http://localhost:4200/ **
i ｢wdm｣: Compiled successfully.
[HPM] GET /litas/orders -> http://localhost:8080

Now generate service and make sure app talks to server.  The folder is 
generated under the app folder of project. now It will have services folder, 
ingredient folder and a file to host services.
  C:\Users\admin\IdeaProjects\litas-ui\litas-ui>ng g service services/ingredient/ingredient
CREATE src/app/services/ingredient.service.spec.ts (353 bytes)
CREATE src/app/services/ingredient.service.ts (139 bytes)
Now add it to the application, that is on the app.module.ts under the provider
import the path for services.  Also add the HttpClientModule


--create component
C:\Users\admin\IdeaProjects\litas-ui\litas-ui>ng g component components/admin


in app.component.html set the router-outlet for the layout and from the routing
app Routes const routes: Routes = [.  so any call from admin path will be 
pointed to AdminComponent (http://localhost:4200/admin)
<div style="text-align: center">
  <h1>
    Welcome to Lita's
  </h1>
</div>
<router-outlet></router-outlet>

Add ng-bootstrap
	-npm install --save @ng-bootstrap/ng-bootstrap
	+ @ng-bootstrap/ng-bootstrap@5.1.2
added 1 package from 1 contributor and audited 18865 packages in 24.069s
found 0 vulnerabilities


Emmet for code editors

-- added@import @import "../node_modules/@angular/material/prebuilt-themes/indigo-pink.css"; 
	in style.css
	
dialog errors
ERROR Error: No component factory found for DialogViewIngredientComponent. 
Did you add it to @NgModule.entryComponents?
 entryComponents: [
    DialogViewIngredientComponent
  ]