# Toktive

## About
Toktive (name not final, suggestions are appreciated) is an API that allows a client/consumer to share their post to all networks in a single action. For now the plan is to make FB and Twitter share work utilizing other third-party APIs for each network.

## Motivation
Ever thought of a post, but ran into the hassle of opening Twitter, Facebook, Instagram, etc. and share it to each and everyone of them? This is the problem every social media/community manager faces everyday.

There are actual applications existing that does more than this (\*ehem\* HootSuite \*ehem\*). But most of these applications are a full dinner course and a show, while all you need is the cupcake. This one is more of an ala-carte solution.

All that said, I'm not that heavy of a poster that needs to do all those things. I might not even think of wasting phone memory to install this app. **The main goal of this project is actually to** let me practice what I'm learning about Spring/Boot, Design Patterns, JPA, etc. I feel like I'm lagging behind on my hands-on project experiences. YouTube, Udemy, and other references online are not enough-- everyone knows that. We need to get our hands dirty, make mistakes, and experience firsthand how to work with them.

## Setup
I made this application in Eclipse 2020-06 (4.16.0), with full support for Java EE. Initial Spring classes and Maven config files are generated via Spring Initializr.

To set this up in Eclipse, all you need to do is simply:
1. Import the project via Git.
2. Setup config files under src/main/resource folder. Remove the SAMPLE prepend on the file name and put your respective dev token values.
    - Setup your own Twitter dev tokens via https://developer.twitter.com/ if you don't have one yet.
    - Setup your own Facebook access token via https://developers.facebook.com/ 
3. Run an mvn install and update the project

While this is created using Eclipse, it's not necessary to stick with it. While not required, it helps to start having the project build with Maven and allow Git to be used. Please look up for the equivalent steps for your preferred IDE.

## Usage
Use `io.github.jmgloria07.toktive.Toktive` and create a singleton instance. Then call the `share` method with the supplied parameters `message` and `networks`. See sample usage at `io.github.jmgloria07.toktive.ToktiveApplication`

## Future plans
- Handle errors with exceptions. Support try-catch resources at the Toktive class.
- Create better API request-response object. Also create a single entry point interface.
- ~~Lookup for any API that would let the app post to FB~~ FB doesn't anymore allow sharing via APIs, as permissions have been removed. With this, the client has to open an external browser. See https://developers.facebook.com/docs/graph-api/changelog/breaking-changes#login-4-24 
- Posting to your Facebook Page may be possible though, will be implementing that shortly.
- Support other SNS platforms (LinkedIn? IG? Stories? Tik...Tok?). 
    - I was supposed to use Spring Social for this, but found out that API has already been deprecated.
- Support images..?
- ~~Currently utilizes property files to work with access tokens, but planning to extend this further to use a DB (H2, perhaps?).~~ I wonder what's the best practice here? I think it's better to have a separate service to login instead. Consumer key and secret can be saved via property but access tokens aren't supposed to be. I should let the client application do the DB.
- Make a separate web project that uses this API, could be Angular/React this time.
- Remove the API dependencies per SNS and manually create a simple implementation 
- The API is highly extensible, so a smartphone app can use this.
