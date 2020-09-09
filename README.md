# Toktive

## About
Toktive (name not final, suggestions are appreciated) is an API that allows a client/consumer to share their post to all networks in a single action. For now the plan is to make ~~Facebook~~ FB Pages and Twitter share work utilizing other third-party APIs for each network.

* Note: FB doesn't anymore allow sharing via their APIs, as permissions have been removed. The client has to open an external browser/tab, which is out of this project's scope. See https://developers.facebook.com/docs/graph-api/changelog/breaking-changes#login-4-24 

## Motivation
Ever thought of a post, but ran into the hassle of opening Twitter, Facebook, Instagram, etc. and share it to each and everyone of them? This is the problem every social media/community manager faces everyday.

There are applications that already exist and even do more than just posting (\*ehem\* HootSuite \*ehem\*). But most of these applications are a full dinner course and a show, while all you need is the cupcake. This one is more of an ala-carte solution.

All that said, I'm not that heavy of a poster that needs to do all those things. I might not even think of using up phone memory to install an app of this (coming soooon...?). **The main goal of this project is actually to** let me practice what I'm learning about Spring/Boot, Design Patterns, JPA, etc. I feel like I'm lagging behind on my hands-on project experiences. YouTube, Udemy, and other references online are not enough-- everyone knows that. We need to get our hands dirty, make mistakes, and experience firsthand how to work with them.

## Setup
I made this application in Eclipse 2020-06 (4.16.0), with full support for Java EE. Initial Spring classes and Maven config files are generated via Spring Initializr.

To set this up in Eclipse, all you need to do is simply:
1. Import the project via Git.
2. Setup config files under src/main/resource folder. Remove the `SAMPLE` prepend on the file name and put your respective dev token values.
    - Setup your own Twitter dev tokens via https://developer.twitter.com/ if you don't have one yet.
    - Setup your own Facebook access token and permissions via https://developers.facebook.com/ 
3. Run an mvn install and update the project. 
4. You may run the application through the main class `io.github.jmgloria07.toktive.ToktiveApplication` to do functional tests. 

While this is created using Eclipse, it's not required build this project. I only went with this IDE since Eclipse is already installed on my machine.

You may even use notepad and manually create the jar if you wish. Please look up for the equivalent steps for your preferred method/IDE.

## Usage
Use `io.github.jmgloria07.toktive.Toktive` and create a singleton instance. Then call the `share` method with the supplied parameters `message` and `networks`. See sample usage at `io.github.jmgloria07.toktive.ToktiveApplication`

## Future plans
- ~~Lookup for any API that would let the app post to FB~~ 
- Proper logging: on-progress
- -----------release 1.0------------------
- ~~Currently utilizes property files to work with access tokens, but planning to extend this further to use a DB (H2, perhaps?).~~ I wonder what's the best practice here? I think it's better to have a separate service to login instead. Consumer key and secret can be saved via property but access tokens aren't supposed to be. I should let the client application do the DB. 
- A singleton implementation on the Toktive class makes sense for now, since we could use a single instance across sessions and that the tokens are hardcoded in the property file. But this should be changed when authentication's implementation is made such that there's a need for a different access token per session.
- Support other SNS platforms (LinkedIn? IG? Stories? Tik...Tok?). 
    - I was supposed to use Spring Social for this, but found out that the said API has already been deprecated.
- Support images..?
- Make a separate web project that uses this API, could be Angular/React this time.
- Remove the API dependencies per SNS and manually create a simple implementation. This project only needs like two to five methods per jar, it would be nice to lessen unnecessary couplings.
- The API is highly extensible, so a smartphone app can use this.