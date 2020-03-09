<#list family?map(f -> f.name) as f>
   ${f?index}     ${f} <br/>
</#list>

<a href="1">by id</a>
<a href="names/andrey">by name</a>
<a href="ages/40">by age</a>
